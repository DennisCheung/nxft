--
-- ����ȦǩԼ��ϵ��
--
-- v1.0 2017.02.13
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_circle_sign;
Create Table  fxp.p_circle_sign (
-- +-----------------------------+--------------+-----------+
   fsign_id                      varchar2(32)   not null,   -- ǩԼid
   fprovider_circle_id           varchar2(32)   not null,   -- �ṩ������Ȧid
   fcustomer_circle_id           varchar2(32)   not null,   -- �ͻ�������Ȧid
   fbusiness_id                  varchar2(32)   not null,   -- ҵ��id
   fsign_desc                    varchar2(256),             -- ��ע 
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
   constraint pk_p_circle_sign primary key (fsign_id),
   constraint uk_p_circle_sign unique (fprovider_circle_id,fcustomer_circle_id,fbusiness_id)
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
