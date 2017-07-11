--
-- ��ͥ��
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_family;
Create Table fxp.p_family (
-- +-----------------------------+--------------+-----------+
   ffamily_id                    varchar2(32)   not null,   -- ��ͥid
   ffamily_code                  varchar2(32)   not null,   -- ��ͥ���
   ffamily_member                varchar2(100),             -- ��ͥ��Ա
   -- fhouseholder_name          varchar2(40),              -- ��������
   -- 
   -- ������
   --
   fagent_name                   varchar2(30)   not null,   -- ����������
   fagent_mobile                 varchar2(30),              -- �������ֻ�
   fagent_user_id                varchar2(32),              -- ������user_id   
   --
   -- ��������Ȧ
   --
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   fteam_id                      varchar2(32)   not null,   -- ��������id
   -- 
   -- ��ϵ��ʽ
   --
   ffamily_Phone                 varchar2(30),              -- ��ͥ�绰
   ffamily_last_Phone            varchar2(30),              -- ��ͥ���º���绰
   -- fpostbox                   varchar2(6),               -- ��������
   fregion_id                    varchar2(32),              -- ��������ID�����а���ʡ���С������ֵ��������ĸ������룩����ֻ����ײ��ַ�ı��룬�����ϼ����룩
   fregion_name                  varchar2(80),              -- �����������ƣ����������������������ƣ��磺�㶫ʡ�����з�خ��)
   faddress                      varchar2(200),             -- ��ϸ��ַ���ֵ�֮�����ϸ��ַ��
   fmap_addr                     varchar2(200),             -- ��ͼ��ַ
   flatitude                     number(19,16),               -- γ��ֵ
   flongitude                    number(19,16),               -- ����ֵ
   --
   -- ��ͥ���
   --
   fliving_condi_name            varchar2(40),             -- ��ס�������ѡ���ö��ŷָ�
   ffamily_desc                  varchar2(256),            -- ��ͥ��ע
   --
   -- ������
   --   
   fcreate_date                  date,                      -- �������ڣ�¼��ʱ��������ڣ� 
   fcreate_user_id               varchar2(32),              -- ��������Աid
   fcreate_user_name             varchar2(30),              -- ��������Ա����   
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
   constraint pk_p_family primary key (ffamily_id),
   constraint uk_p_family_code unique (ffamily_code)
-- constraint uk_p_family_fixPhone unique (ffamily_fixPhone)
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
-- create index idx_p_family1 on fxp.p_family(fregion_id);
create index idx_p_family_agent on fxp.p_family(fagent_mobile);
create index idx_p_family_phone on fxp.p_family(ffamily_Phone);


--
-- �޸���䣺
--
