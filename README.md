[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/rafiibrahim8/VerilogX">
    <img src="img/logo_360x360.png" alt="VerilogX logo" width="96" height="96">
  </a>

  <p align="center">
  A simple, easy, and fast Verilog Simulator
  </p>
</p>

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About VerilogX](#about-verilogx)
* [Motivation](#motivation)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)


## About VerilogX

VerilogX is a Verilog simulation software that enables quick debugging of Verilog files. It uses Icarus Verilog (iverilog) and GTKWave to efficiently show output waveform.

## Motivation

During the final year of my University, I had to use Verilog for one of my courses. The software we use to simulate was decades old. It took minutes to configure and view the resultant waveform. Debugging was a nightmare. Changing a single word in the code then simulating it took so much time I started to get angry. 

I was looking for a way to easily run my Verilog files. Thus, VerilogX was born.

## Getting Started

It's easy to install and run VerilogX.

### Prerequisites

- Code Editor

I recommend to use [Visual Studio Code](https://code.visualstudio.com) or [Sublime Text 3](https://www.sublimetext.com/3) along with Verilog extension.

#### Note For Windows User

You need to have Java installed in your system.
You can download Java (JRE) from [here](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).


### Installation

#### Linux

- Download `VerilogX-Linux-v0.1.tar.gz` from [here](https://github.com/rafiibrahim8/VerilogX/releases/tag/v0.1).

- Open terminal at the downloaded location. And enter the following commands:
```sh
tar -xvf VerilogX-Linux-v0.1.tar.gz
cd VerilogX-Linux
sudo bash VerilogX-install.sh
```

#### Windows

- Download `VerilogX-Windows-v0.1.exe` from [here](https://github.com/rafiibrahim8/VerilogX/releases/tag/v0.1).
- Double click it to install.

## Roadmap

See the [open issues](https://github.com/rafiibrahim8/VerilogX/issues) for a list of problems, suggestions and solution (and known issues).


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.


<!-- CONTACT -->
## Contact

Ibrahim Rafi - me@ibrahimrafi.me


<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

Abdullah Al Mamun - mamunabdullah275@gmail.com - for designing the beautiful logo.

Pablo Bleyer Kocik - pablo.N@SPAM.bleyer.org - for Windows binary for iverilog and gtkwave.

Stephen Williams - steve@icarus.com - for Icarus Verilog (iverilog).

Free Software Foundation, Inc. - [Website](https://www.fsf.org) - for GTKWave.

Khude Gobeshok - [Website](https://app.khudegobeshok.com) - for their awesome README [template](https://github.com/khudegobeshok/arduino-learning-kit/blob/master/README.md).


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[stars-shield]: https://img.shields.io/github/stars/rafiibrahim8/VerilogX.svg?style=flat-square
[stars-url]: https://github.com/rafiibrahim8/VerilogX/stargazers
[issues-shield]: https://img.shields.io/github/issues/rafiibrahim8/VerilogX.svg?style=flat-square
[issues-url]: https://github.com/rafiibrahim8/VerilogX/issues
[license-shield]: https://img.shields.io/github/license/rafiibrahim8/VerilogX.svg?style=flat-square
[license-url]: https://github.com/rafiibrahim8/VerilogX/blob/master/LICENSE
