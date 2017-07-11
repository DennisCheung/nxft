# 暖心饭堂

## 开发时如何启动？

`nxft-web-dev`是专为开发建立的工程，你既可以用maven启动，也可在eclipse里启动。注意，需先启动h2数据库才可启动程序。

### 用maven启动

请先进入到`nxft根目录`然后执行：

    mvn spring-boot:run -pl d99/nxft-web-dev -am -Pdev

### 在eclipse里启动

    右键nxft-web-dev工程的NxftDevApplication -> Run As/Debug As -> Java Application

### 打开系统

不论是用maven启动还是用eclipse启动，启动后请打开浏览器，请输入：

    http://localhost:8353/nxft-web/v/kitchen 厨房
    http://localhost:8353/nxft-web/v/meal  助餐
    http://localhost:8353/nxft-web/v/assist  点餐

   测试用户：　　00001/11111
   厨房用户：    00041/11111

