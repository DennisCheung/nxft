--
-- �û�΢�Ű󶨱�
--
-- v1.0 2016.03.15
-- author��wing
--
-- ˵��
-- 1���˱�Ϊ�ͻ���ע�����ʱʹ�ã���ҵ�Ų��ô˱�
-- 2��PC�������ͻ���Ϣʱ����p_user
-- 3���û�ע�᳡����
--    3.1 ͨ����ע΢�ŷ���š������������� ��Ϊ�û���ʵ�ֺ�΢�ŷ���ŵİ󶨣�ͬʱ�� p_user �� p_user_wechat����
-- 4���ͻ�ʹ��΢�ŷ����Ӧ�ã�ͨ�� open_id  �� p_user_wechat �л�ȡ fuser_id  
-- 5��΢��Ӧ�ò����õ�p_user��,�������룬PC��Ӧ��ʹ�� p_user �� ��
-- 6���ͻ�΢�ŷ������Ϊһ����������ϵͳ��
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_user_wechat;
create table  fxp.p_user_wechat (
-- +-----------------------------+--------------+-----------+
   fopen_id                      varchar2(128)  not null,   -- �󶨵�΢�ź�id
   fuser_id                      varchar2(32)   not null,   -- �û�ID��     
   fpublic_no                    varchar2(128)  not null,   -- ΢�Ź��ں�
   fwechat_name                  varchar2(50)   not null,   -- ΢���ǳ�
   fwechat_area                  varchar2(50),              -- ΢�ŵ���
   fwechat_sex                   varchar2(10),              -- ΢���Ա�
-- +-----------------------------+--------------+-----------+
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
   constraint pk_p_user_wechat primary key (fopen_id),
   constraint uk_p_user_wechat unique (fuser_id,fpublic_no)
   --
   -- Լ��
   --
);

--
-- ͬ���
--

--
-- ��Ȩ
--

--
-- ����
--

--
-- �޸����
--
