--
-- ΢����ҵ���û���
--
-- v1.0 2016.08.12
-- author��wing
--
-- ˵��
-- 1��fqyh_user_id = ��ҵ��ͨѶ¼ userId 
--
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_qyh_user;
create table  fxp.p_qyh_user (
-- +-----------------------------+--------------+-----------+
   fqyh_user_id                  varchar2(64)   not null,   -- ΢����ҵ��user id
   fuser_type                    varchar2(20),              -- 2017.05.01 �ָ� �û����� ����   UNORG  ɢ��  EMP ְ��
   fuser_name                    varchar2(50)   not null,   -- ����
   fsex_id                       varchar2(32),              -- �Ա�id
   fsex_name                     varchar2(10),              -- �Ա�����
   fweixinid                     varchar2(64),              -- ע��΢�ź�
   fmobile                       varchar2(20),              -- ע���ֻ���
   femail                        varchar2(30),              -- ע�������
   fuser_id                      varchar2(32)   not null,   -- �û�ID
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
   constraint pk_p_qyh_user primary key (fqyh_user_id)
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
