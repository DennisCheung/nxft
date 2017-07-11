@echo off
@echo *
@echo * 本批命令脚本用于执行数据导出、导入和比较操作。
@echo * 执行前你需先手工在制作好“..\h2script\h2nxft-库结构.sql”文件。
@echo *

set curdir=%cd%

:l_begin
rem 设置内存大小
set MAVEN_OPTS=-Xms512m -Xmx512m -XX:MaxPermSize=256m

cd %curdir%

set choice=""
echo ===
echo 1. 从db8 oracle导出nxft用户的全部表数据（不含表结构）
echo 2. 重建本地H2库结构和数据
echo 3. 校验本地导入数据是否正确
echo 4. 重建58云服务器H2库结构和数据
echo 5. 重建128云服务器H2库结构和数据
echo 6. 导入测试xml数据
echo 8. 下载128数据库
echo 9. 重建本地H2库结构和数据（导入128数据库）

echo 0. 退出
set /p choice=请选择（直接回车默认为选择0）：
if "%choice%" == """" goto l_end
if "%choice%" == "0" goto l_end
if "%choice%" == "1" goto l_export
if "%choice%" == "2" goto l_import
if "%choice%" == "3" goto l_compare
if "%choice%" == "4" goto l_impcloud
if "%choice%" == "5" goto l_impcloud128
if "%choice%" == "6" goto l_imptest
if "%choice%" == "8" goto l_download128
if "%choice%" == "9" goto l_import128
if "%choice%" == "60" goto l_init
if "%choice%" == "6a" goto l_init_all
if "%choice%" == "6u" goto l_init_user
if "%choice%" == "12" goto l_import_hbcs
goto l_begin

:l_export
cd %curdir%\nxft-dbsync-tools
call mvn dbunit:export exec:java -Pexport-from-db8-oracle
goto l_begin

:l_export128
cd %curdir%\nxft-dbsync-tools
call mvn dbunit:export -Pexport-from-128cloud-h2
goto l_begin

:l_import
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/nxft;MODE=Oracle -user sa -password "" -script "../fxp/h2script/h2fxp-库结构.sql"
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/nxft;MODE=Oracle -user sa -password "" -script "../h2script/h2nxft-库结构.sql"

cd %curdir%\..\fxp\tools\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-to-local-h2 -Ddatabase.name=nxft

cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-to-local-h2  -Ddatabase.name=nxft
goto l_begin

:l_import_hbcs
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/hbcs;MODE=Oracle -user sa -password "" -script "../h2script/h2nxft-库结构.sql"

cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-to-local-h2 -Ddatabase.name=hbcs

goto l_begin

:l_imptest
set /p ctestpath=请输入测试文件的路径及文件名：
cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-test-to-local-h2 -Ddatabase.name=nxft -Dctestpath=%ctestpath%
goto l_begin

:l_impcloud58
set /p c58password=请输入58云服务器H2数据库sa用户的密码：
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://211.149.208.58/~/h2/nxftprod;MODE=Oracle -user sa -password %c58password%  -script "../fxp/h2script/h2fxp-库结构.sql"
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://211.149.208.58/~/h2/nxftprod;MODE=Oracle -user sa -password %c58password%  -script "../h2script/h2nxft-库结构.sql"

cd %curdir%\..\fxp\tools\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-to-58cloud-h2 -Ddatabase.name=hcaprod

cd %curdir%\hca-dbsync-tools
call mvn dbunit:operation -Pimport-to-58cloud-h2 -Dc58password=%c58password%
goto l_begin

:l_impcloud128
set /p c128password=请输入128云服务器H2数据库sa用户的密码：
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://211.149.243.128/~/h2/hbcsprod;MODE=Oracle -user sa -password %c128password%  -script "../fxp/h2script/h2fxp-库结构.sql"
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://211.149.243.128/~/h2/hbcsprod;MODE=Oracle -user sa -password %c128password%  -script "../h2script/h2nxft-库结构.sql"

cd %curdir%\..\fxp\tools\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-to-128cloud-h2 -Ddatabase.name=hbcsprod -Dc128password=%c128password%

cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-to-128cloud-h2 -Dc128password=%c128password%
goto l_begin

:l_compare
cd %curdir%\nxft-dbsync-tools
call mvn dbunit:compare -Pimport-to-local-h2
goto l_begin

:l_download128
if not exist temp mkdir temp
start /wait bin/download-hbcsprod.sh
goto l_begin

:l_import128
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/nxft;MODE=PostgreSQL -user sa -script %cd%/bin/drop-all.sql
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/nxft;MODE=PostgreSQL -user sa -script %cd%/temp/nxftprod.zip -options compression zip
@echo 导入完成。
goto l_begin

:l_init

cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-init_to-local-h2 -Ddatabase.name=nxft
goto l_begin

:l_init_all

cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-init_all_to-local-h2 -Ddatabase.name=nxft
goto l_begin

:l_init_user

cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-init_user_to-local-h2 -Ddatabase.name=nxft
goto l_begin


:l_end
set MAVEN_OPTS=
