@echo off
@echo *
@echo * ��������ű�����ִ�����ݵ���������ͱȽϲ�����
@echo * ִ��ǰ�������ֹ��������á�..\h2script\h2nxft-��ṹ.sql���ļ���
@echo *

set curdir=%cd%

:l_begin
rem �����ڴ��С
set MAVEN_OPTS=-Xms512m -Xmx512m -XX:MaxPermSize=256m

cd %curdir%

set choice=""
echo ===
echo 1. ��db8 oracle����nxft�û���ȫ�������ݣ�������ṹ��
echo 2. �ؽ�����H2��ṹ������
echo 3. У�鱾�ص��������Ƿ���ȷ
echo 4. �ؽ�58�Ʒ�����H2��ṹ������
echo 5. �ؽ�128�Ʒ�����H2��ṹ������
echo 6. �������xml����
echo 8. ����128���ݿ�
echo 9. �ؽ�����H2��ṹ�����ݣ�����128���ݿ⣩

echo 0. �˳�
set /p choice=��ѡ��ֱ�ӻس�Ĭ��Ϊѡ��0����
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
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/nxft;MODE=Oracle -user sa -password "" -script "../fxp/h2script/h2fxp-��ṹ.sql"
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/nxft;MODE=Oracle -user sa -password "" -script "../h2script/h2nxft-��ṹ.sql"

cd %curdir%\..\fxp\tools\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-to-local-h2 -Ddatabase.name=nxft

cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-to-local-h2  -Ddatabase.name=nxft
goto l_begin

:l_import_hbcs
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/h2/hbcs;MODE=Oracle -user sa -password "" -script "../h2script/h2nxft-��ṹ.sql"

cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-to-local-h2 -Ddatabase.name=hbcs

goto l_begin

:l_imptest
set /p ctestpath=����������ļ���·�����ļ�����
cd %curdir%\nxft-dbsync-tools
call mvn dbunit:operation -Pimport-test-to-local-h2 -Ddatabase.name=nxft -Dctestpath=%ctestpath%
goto l_begin

:l_impcloud58
set /p c58password=������58�Ʒ�����H2���ݿ�sa�û������룺
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://211.149.208.58/~/h2/nxftprod;MODE=Oracle -user sa -password %c58password%  -script "../fxp/h2script/h2fxp-��ṹ.sql"
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://211.149.208.58/~/h2/nxftprod;MODE=Oracle -user sa -password %c58password%  -script "../h2script/h2nxft-��ṹ.sql"

cd %curdir%\..\fxp\tools\fxp-dbsync-tools
call mvn dbunit:operation -Pimport-to-58cloud-h2 -Ddatabase.name=hcaprod

cd %curdir%\hca-dbsync-tools
call mvn dbunit:operation -Pimport-to-58cloud-h2 -Dc58password=%c58password%
goto l_begin

:l_impcloud128
set /p c128password=������128�Ʒ�����H2���ݿ�sa�û������룺
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://211.149.243.128/~/h2/hbcsprod;MODE=Oracle -user sa -password %c128password%  -script "../fxp/h2script/h2fxp-��ṹ.sql"
call java -classpath "D:\jt\m2-repo\com\h2database\h2\1.4.186\h2-1.4.186.jar" org.h2.tools.RunScript -url jdbc:h2:tcp://211.149.243.128/~/h2/hbcsprod;MODE=Oracle -user sa -password %c128password%  -script "../h2script/h2nxft-��ṹ.sql"

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
@echo ������ɡ�
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
