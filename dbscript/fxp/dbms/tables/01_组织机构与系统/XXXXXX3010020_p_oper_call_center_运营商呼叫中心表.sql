--
-- ��Ӫ�̺������ı�
--
-- v1.0 2016.08.09
-- author��wing
--
-- 
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_oper_call_center;
Create Table  fxp.p_oper_call_center (
-- +-----------------------------+--------------+-----------+
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
   fcall_center_id               varchar2(32)   not null,   -- ��������id
   forg_id                       varchar2(32)   not null,   -- ����id 
-- +-----------------------------+--------------+-----------+
   --
   -- ����
   --
   fcreate_date                  date default sysdate not null, -- �������ڣ�¼��ʱ��������ڣ� 
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
   constraint pk_p_oper_call_center primary key (foperator_id,fcall_center_id)
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
