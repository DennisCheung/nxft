--
-- ��Ʒ��
--
--
-- v1.0 2017.03.14
-- author��wing
--
-- ˵����
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_goods ;
Create Table  fxp.p_goods (
-- +-----------------------------+--------------+-----------+
   fgoods_id                     varchar2(32)   not null,   -- ��Ʒid
   fgoods_code                   varchar2(30)   not null,   -- ��Ʒcode
   fgoods_name                   varchar2(100)  not null,   -- ��Ʒ����
   fbusiness_id                  varchar2(32)   not null,   -- ҵ��id
   fgoods_info                   varchar2(2000) not null,   -- ��Ʒ��ϸ��Ϣ
   fgoods_price                  number(10,2)   not null,   -- ��Ʒ����
   fgoods_unit                   varchar2(30)   not null,   -- ��λ
   fgoods_desc                   varchar2(256),             -- ��Ʒ�ı�ע
   --
   -- ����Ȧ
   --
   fcircle_id                    varchar2(32)   not null,   -- ��������Ȧid���ϼ��ߣ�  
   --
   -- ����
   --
   fcreate_date                  date           not null,   -- ����ʱ��  
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(30)   not null,   -- ��������Ա����      
   --
   -- ȡ��
   --
   fis_cancel                    char(1) default 'N'  not null, -- �Ƿ�ע��
   fcancel_reason                varchar2(100),             -- ע��ԭ��
   fcancel_date                  date,                      -- ע��ʱ��
   fcancel_user_id               varchar2(32),              -- ע������Աid
   fcancel_nickname              varchar2(40),              -- ע������Ա����   
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
   constraint pk_p_goods primary key (fgoods_id),
   constraint uk_p_goods unique (fcircle_id,fgoods_code)
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
