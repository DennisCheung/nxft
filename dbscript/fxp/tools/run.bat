@echo off
@echo *
@echo * ��������ű�����ִ�����ݵ���������ͱȽϲ�����
@echo * ִ��ǰ�������ֹ��������á�..\h2script\h2fxp-��ṹ.sql���ļ���
@echo *

set curdir=%cd%

:l_begin
rem �����ڴ��С
set MAVEN_OPTS=-Xms512m -Xmx512m -XX:MaxPermSize=256m

cd %curdir%

set choice=""
echo ===
echo 1. ��db8 oracle����fxp�û���ȫ�������ݣ�������ṹ��
echo 2. �ؽ�����H2-FXP��ṹ������
echo 3. У�鱾��H2-FXP���������Ƿ���ȷ
echo 4. �������xml����

echo 0. �˳�
set /p choice=��ѡ��ֱ�ӻس�Ĭ��Ϊѡ��0����
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
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/fxp;MODE=Oracle -user sa -password "" -script "../h2script/h2fxp-��ṹ.sql"

cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-to-local-h2 -Ddatabase.name=fxp
goto l_begin

:l_compare
cd %curdir%\fxp-dbsync-tools
call mvn dbunit:compare -Pimport-to-local-h2 -Ddatabase.name=fxp
goto l_begin

:l_imptest
set /p ctestpath=����������ļ���·�����ļ�����
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
set /p ctestpath=�����뵼��128�ļ���·�����ļ�����
set /p c128password=������128�Ʒ�����H2���ݿ�sa�û������룺
cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-test-to-128-h2 -Dc128password=%c128password%  -Dctestpath=%ctestpath%
goto l_begin

:l_imptest_198
set /p ctestpath=�����뵼��198�ļ���·�����ļ�����
set /p c198password=������198�Ʒ�����H2���ݿ�sa�û������룺
cd %curdir%\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-test-to-198-h2 -Dc61password=%c198password%  -Dctestpath=%ctestpath%
goto l_begin

:l_end
set MAVEN_OPTS=
