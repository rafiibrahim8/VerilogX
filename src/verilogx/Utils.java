/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verilogx;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.ImageIcon;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;

/**
 *
 * @author ibrahim
 */
public class Utils {

    private static final String[] exponents = new String[]{"ps", "ns", "us", "ms", "s"};
    private static final String SIM_PARAMS
            = "initial begin" + System.lineSeparator()
            + "$dumpfile(\"__vcdfile__\");" + System.lineSeparator()
            + "$dumpvars(0,__modulename__);" + System.lineSeparator()
            + "#__simtime__ $finish;" + System.lineSeparator()
            + "end" + System.lineSeparator()
            + "endmodule" + System.lineSeparator();

    public static boolean checkExist(ArrayList<String> where, String which) {
        for (Object o : where.toArray()) {
            if (which.equals((String) o)) {
                return true;
            }
        }
        return false;
    }

    public static FileFilter verilogOnlyFilter() {
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getAbsolutePath().endsWith(".v");
            }

        };
        return filter;
    }

    public static String[] getTimeScale(StringX content) {
        String timeScaleStr = null;
        for (String s : content.toString().split(System.lineSeparator())) {
            if (s.replaceAll(" ", "").startsWith("`timescale")) {
                timeScaleStr = s;
                break;
            }
        }

        if (timeScaleStr == null) {
            timeScaleStr = "`timescale 1ns/1ns";
            content.addTop(timeScaleStr);
        }

        try {
            timeScaleStr = timeScaleStr.split("/")[0].replaceAll(" ", "").replace("`timescale", "");
            int howLongDigit = 0;
            for (; howLongDigit < timeScaleStr.length(); howLongDigit++) {
                if (!Character.isDigit(timeScaleStr.charAt(howLongDigit))) {
                    break;
                }
            }

            String[] ret = new String[]{timeScaleStr.substring(0, howLongDigit), timeScaleStr.substring(howLongDigit).toLowerCase()};
            return ret;

        } catch (Exception ex) {
            return new String[]{"1", "us"};

        }
    }

    public static int getSimTimeHash(String[] timeScale, String simTime, String simTimeUnit) {
        float tsTime = Float.parseFloat(timeScale[0]);
        float simTime_ = Float.parseFloat(simTime);
        double exp = Math.pow(10, 3 * (getExp(simTimeUnit) - getExp(timeScale[1])));
        return (int) ((simTime_ / tsTime) * exp);
    }

    public static void nativeNewline(StringX content) {
        content.editTo(content.toString().replaceAll("\r\n|\n|\r", System.lineSeparator()));

    }

    private static int getExp(String x) {
        for (int i = 0; i < exponents.length; i++) {
            if (x.equalsIgnoreCase(exponents[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    public static String[] getSubs(ArrayList<String> openedFiles, String folderPath, String simFile) {
        ArrayList<String> ret = new ArrayList<>();
        String parent = folderPath == null ? "" : folderPath + File.separator;
        Object[] of = openedFiles.toArray();
        for (Object o : of) {
            String element = (String) o;
            if (!simFile.equals(element)) {
                ret.add(parent + element);
            }
        }
        return ret.toArray(new String[0]);
    }

    public static String getModuleName(StringX content) {
        for (String s : content.toString().split(System.lineSeparator())) {
            String whRemoved = s.replaceAll(" ", "");
            if (whRemoved.startsWith("module")) {
                return whRemoved.replace("module", "").split(";")[0].split("\\(")[0];
            }
        }
        return "NO_MODULE_FOUND";
    }

    public static void addSimParams(StringX content, String vcdFilePath, String moduleName, int simTimeHash) {
        if (!content.toString().contains("endmodule")) {
            throw new IllegalArgumentException();
        }
        String vcdFilePath_ = vcdFilePath.replace("\\", "/"); //iverilog doen't support \ (default saparator for windows)
        String simParams = SIM_PARAMS.replace("__vcdfile__", vcdFilePath_).replace("__modulename__", moduleName).replace("__simtime__", "" + simTimeHash);
        content.replace("endmodule", simParams);
    }

    public static ExecResult runCommand(CommandLine cmd) throws IOException {
        return runCommandDir(null, cmd);
    }

    public static ExecResult runCommandDir(String directory, CommandLine cmd) throws IOException {
        int code = -999;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Executor executor = new DefaultExecutor();
        if (directory != null) {
            executor.setWorkingDirectory(new File(directory));
        }
        executor.setStreamHandler(new PumpStreamHandler(stream));
        try {
            code = executor.execute(cmd);
        } catch (Exception ex) {
        }
        return new ExecResult(stream.toString(), code);

    }

    public static void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteRecursive(f);
            }
        } else {
            try {
                file.delete();
            } catch (Exception ex) {
            }
        }
    }

    public static Image getIcon() {
        String icon_64 = "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";
        return new ImageIcon(Base64.getDecoder().decode(icon_64)).getImage();
    }
}
