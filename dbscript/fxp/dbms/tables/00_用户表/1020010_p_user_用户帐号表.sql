--
-- �û��ʺű�
--
-- v1.0 2015.11.09
-- author��wing
-- ˵����
-- 1���û��������ͻ���ְ��������ʹ��ϵͳʹ����ʿ��
-- 2��ְ���û�
--  2.1�����ְ����
--    �� �Զ����û���P_USER������һ����¼��
--       fuser_id = femp_id
--       ϵͳ���ý׶�fpassword=11111  ��ʽʹ�ý׶Σ��״�ʹ��ִ�С��������롱���ܣ�ͨ��ְ���Ǽǵ��ֻ�����У������ʼ������������롣
--       fnickname = femp_name
--    �� ��绰��Ϊ�գ���p_user_mobile
--    �� �����䲻Ϊ�գ���p_user_email
--  2.2�� �޸�ְ����
--    �� ʵ��p_employee ��p_user,p_user_mobile,p_user_emai ��Ϣͬ��
--  2.3�� ְ����¼(APP,WEB)
--    ��  ����user_id������
--    ��  ����Ǽǵ��ֻ��ź�����
--    ��  ����Ǽǵ�����ź�����
--   2.4  ְ��΢����ҵ�Ű�
--    ��  ͨѶ¼�еǼ��ֻ��Ż������΢�źţ�����������ע����
--    ��  ְ��ȷ�Ϲ�ע������OPEN_ID �� ͨѶ¼ְ���İ󶨹�ϵ
--   2.5  ְ��΢����ҵ�ŵ�¼
--    ��  ����΢�ţ�ְ������= ͨѶ¼�˺ţ� �ҵ�user_id
--
--
-- 3���û�ע�᣺
--   3.1�� ͨ�����ֶˣ�QQ��ʽ��΢�š�APP��WEB�����û�ע�ᡱ���ܣ�ע���Ϊ�û�
--         fuser_id  ͨ�����к��Զ����ɡ�
--         fpassword  ������ٴ�ȷ������
--         �����ǳơ��Ա�
--         ����ע����֤���ֻ�����ͨ��������֤��
--         �������䣨��Ϊ�գ�
--   3.2�����û���΢����ڣ��Զ�ʵ��΢��OPEN_ID ��user_id�󶨣������󶨹�ϵ�洢�� p_user_wachart
--   3.3�����û���΢����ڣ�ͨ������user_id��ע���ֻ������䣩 �� ����
--
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_user;
create table  fxp.p_user (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�id
   fpassword                     varchar2(50),              -- �û����룬��������ܴ洢�����Ϊ�ղ�����ֱ�������û�id��¼
   fnickname                     varchar2(50)   not null,   -- ��ʾ��(�ǳƣ�
   fsex_id                       varchar2(32),              -- �Ա�id
   fsex_name                     varchar2(10),              -- �Ա�����
   fphoto_id                     varchar2(32),              -- ����ͷ��id
   fsignature_id                 varchar2(32),              -- ����ǩ��id
   fmobile                       varchar2(20),              -- �ֻ���
   fuser_desc                    varchar2(256),             -- ��ע
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_user primary key (fuser_id)
   --
   -- Լ��
   --
 --  constraint ck_p_user_fis_activated check (fis_activated in ('Y','N'))
);

alter table FXP.p_user
  add constraint UK_p_user_fmobile unique (fmobile);

--
-- ��Ȩ
--
  grant all on fxp.p_user to sf,hbcs;
--
-- ����
--

--
-- �޸����
--

--
-- ��ʼ����
--


