--
-- ����ȦECP���ñ�
--
-- v1.0 2017.02.13
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_circle_ecp;
Create Table  fxp.p_circle_ecp (
-- +-----------------------------+--------------+-----------+
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   fecp_account                  varchar2(100)  not null,   -- ECP�˺�
   fecp_password                 varchar2(30)   not null,   -- ECP����
   fecp_key                      varchar2(100)  not null,   -- ECP����KEY
   --
   -- ����
   --
   --
   -- �ʼ�
   --   
   fecp_desc                     varchar2(256),             -- ��ע 
-- +-----------------------------+--------------+-----------+
   --
   -- ������
   --
   fcreate_time                  date default sysdate not null, -- ����ʱ�� 
   fcreate_user_id               varchar2(32)  not null,   -- ��������Աid
   fcreate_user_name             varchar2(50)  not null,   -- ��������Ա����
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
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
   constraint pk_p_circle_ecp primary key (fcircle_id)
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
-- �޸���䣺
--
