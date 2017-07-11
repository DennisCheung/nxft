# hwq-it-htmldb工程说明

本工程用于对hwq项目的从html页面到数据库的全程测试。每个测试对应于一个测试故事，测试故事由需求提供，开发据此编写测试代码。

本工程的测试故事同服务端的测试用例不同，测试用例不通过不允许提交代码，但测试故事不通过时允许手工审核提交代码。测试故事在整个研发过程中起到两个作用：

1、开发申请需求做测试的前置条件。开发完成或初步完成代码后，请先自己执行测试故事，只当测试故事通过后方可要求需求做进一步的人工测试。

2、产品发版的前置条件。只当测试故事通过后方可发版，正式部署。

本工程支持本地开发和Jenkins两种使用场景。

## 测试模式

本工程支持内嵌和分离两种测试模式。

1、内嵌测试模式。该模式让测试对象和测试服务器在同一个进程中启动，其缺点是执行测试速度慢，但适用于模拟对象的测试。要使用该测试模式请继承`AbstractHwqEmbedHtmlDbTest`基类。

2、分离测试模式。该模式需要先手工启动测试服务器，然后再执行测试。测试服务器只需启动一次，而非每次跑测试时都启动，这样一来就提高了测试开发速度。但其缺点是无法进行模拟测试。要使用该测试模式请继承`AbstractHwqSeperateHtmlDbTest`基类。

## 如何手工启动测试服务器？

你可在eclipse里启动测试服务器，也可用maven命令启动：

    mvn spring-boot:run -pl hwq-it-htmldb -am

## 测试驱动器

本地开发时将默认使用Firefox浏览器跑测试，并把Firefox设置到屏幕左上角位置。若你需要用其它浏览器测试则请参见本文档的后面章节进行设置。

在Jenkins里将使用无界面的HtmlUnitDriver驱动器跑测试。注意，无界面测试只是看不到界面，但仍然是html。

## 如何设置Firefox？

[selenium](http://www.seleniumhq.org/)提供了两个基于Firefox测试的驱动器，一个是`FirefoxDriver`，另一个是`MarionetteDriver`，对于高版本的Firefox (`47+`)需要使用后者，并同时需要你下载`geckodriver.exe`文件到本地。

目前最新的Firefox版本为`49.0`，故此我们需要在本地操作：

1、从[官网](https://github.com/mozilla/geckodriver/releases)下载`geckodriver-v0.9.0-win64.zip`版本，勿下载当前最新的`v0.10.0`版本，具体原因请参见：[issues#158](https://github.com/mozilla/geckodriver/issues/158)。

2、解压下载的`geckodriver-v0.9.0-win64.zip`文件，将其`geckodriver.exe`放入`d:\jt\webdriver`文件夹里。

## 如何设置Chrome？

同高版本的Firefox一样，我们需要下载驱动器到本地，然后才可使用Chrome浏览器做测试，具体操作如下：

1、请从[官网](http://chromedriver.storage.googleapis.com/index.html)下载当前最新的`2.24`版本，文件名为`chromedriver-win32.zip`。

2、解压下载的`chromedriver-win32.zip`文件，将其`chromedriver.exe`放入`d:\jt\webdriver`文件夹里。

此外，本工程默认使用Firefox浏览器，若要使用Chrome则需设置环境变量，见后。

## 如何选择使用哪个浏览器做测试？

本地开发时默认地将使用Firefox进行测试。若你想使用Chrome浏览器则需设置`it.driverName`环境变量，并赋值为`chrome`。

## Maven

在maven中执行又细分为两种，一是`mvn verify`，二是`mvn spring-boot:run`。

1、`mvn verify`。将自动启动测试服务器，然后跑所有的测试。为防止服务器端口冲突，我们把其设置为随机端口号。

2、`mvn spring-boot:run`。如同在eclipse里启动一样，将只启动服务器，不跑测试，并且端口号为在属性文件中定义的静态值（如`8080`）。

## Jenkins

在Jenkins里用Maven执行测试：

    mvn clean verify -U -Dspring.profiles.active=prod,jenkins

该Maven命令将自动启动测试服务器，然后跑所有的测试。为防止服务器端口冲突，我们把其设置为随机端口号。

Jenkins测试时不用Firefox，而用HtmlUnit进行无界面测试。注意，无界面测试只是看不到界面，但仍然是html。

## 测试数据库

1、测试数据库名为hwqit，本地开发时使用本机的H2服务器，Jenkins上使用jenkins.benewit.com的H2服务器。

2、不论是本地还是Jenkins，你都无需手工创建和干预测试数据库。测试数据库将在测试服务器启动时自动创建或重建，清空所有数据、只留下表结构。
