--
-- �������
--
--
-- v1.0 2016.08.30
-- author��wing
--
-- ˵����
-- 
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_activity_crowds ;
Create Table  fxp.p_activity_crowds (
-- +-----------------------------+--------------+-----------+
   fcrowds_id                    varchar2(32)   not null,   -- ����id
   fcrowds_name                  varchar2(100)  not null,   -- ��������    
   fcrowds_desc                  varchar2(256),             -- ��ע
   --
   -- �����Ļ
   --
   factivity_id                  varchar2(32)   not null,   -- �id   
   --
   -- ������Ӫ��
   --
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id    
   --
   -- ����
   --
   fcreate_date                  date           not null,   -- ����ʱ��  
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_nickname              varchar2(30)   not null,   -- ��������Ա����      
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
   constraint pk_p_activity_crowds primary key (fcrowds_id)
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


