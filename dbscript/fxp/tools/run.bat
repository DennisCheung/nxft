@echo off
@echo *
@echo * 本批命令脚本用于执行数据导出、导入和比较操作。
@echo * 执行前你需先手工在制作好“..\h2script\h2fxp-库结构.sql”文件。
@echo *

set curdir=%cd%

:l_begin
rem 设置内存大小
set MAVEN_OPTS=-Xms512m -Xmx512m -XX:MaxPermSize=256m

cd %curdir%

set choice=""
echo ===
echo 1. 从db8 oracle导出fxp用户的全部表数据（不含表结构）
echo 2. 重建本地H2-FXP库结构和数据
echo 3. 校验本地H2-FXP导入数据是否正确
echo 4. 导入测试xml数据

echo 0. 退出
set /p choice=请选择（直接回车默认为选择0）：
if "%choice%" == """" goto l_end
if "%choice%" == "0" goto l_end
if "%choice%" == "1" goto l_export
if "%choice%" == "2" goto l_import
if "%choice%" == "3" goto l_compare
if "%choice%" == "4" goto l_imptest
if "%choice%" == "40" goto l_init
if "%choice%" == "4a" goto l_init_all
if "%choice%" == "4u" goto l_init_user
if "%choice%" == "4128" goto l_imptest_128
if "%choice%" == "4198" goto l_imptest_198
goto l_begin

:l_export
cd %curdir%\fxp-dbsync-tools
call mvn dbunit:export exec:java -Pexport-from-db8-oracle
goto l_begin

:l_import
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/fxp;MODE=Oracle -user sa -password "" -script "../h2script/h2fxp-库结构.sql"

cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-to-local-h2 -Ddatabase.name=fxp
goto l_begin

:l_compare
cd %curdir%\fxp-dbsync-tools
call mvn dbunit:compare -Pimport-to-local-h2 -Ddatabase.name=fxp
goto l_begin

:l_imptest
set /p ctestpath=请输入测试文件的路径及文件名：
cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-test-to-local-h2 -Ddatabase.name=fxp -Dctestpath=%ctestpath%
goto l_begin

:l_init

cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-init_to-local-h2 -Ddatabase.name=fxp
goto l_begin

:l_init_all

cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-init_all_to-local-h2 -Ddatabase.name=fxp
goto l_begin

:l_init_user

cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-init_user_to-local-h2 -Ddatabase.name=fxp
goto l_begin

:l_imptest_128
set /p ctestpath=请输入导入128文件的路径及文件名：
set /p c128password=请输入128云服务器H2数据库sa用户的密码：
cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-test-to-128-h2 -Dc128password=%c128password%  -Dctestpath=%ctestpath%
goto l_begin

:l_imptest_198
set /p ctestpath=请输入导入198文件的路径及文件名：
set /p c198password=请输入198云服务器H2数据库sa用户的密码：
cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-test-to-198-h2 -Dc61password=%c198password%  -Dctestpath=%ctestpath%
goto l_begin

:l_end
set MAVEN_OPTS=
