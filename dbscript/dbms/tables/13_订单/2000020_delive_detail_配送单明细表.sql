--
-- ���͵���ϸ��
--
-- v1.0 2017.04.30
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table nxft.delive_detail;
create table  nxft.delive_detail (
-- +-----------------------------+--------------+-----------+
   fdetail_id                    varchar2(32)   not null,   -- ��ϸID
   --
   -- ����
   --
   fmeal_id                      varchar2(32)   not null,   -- �ײ�id
   fmeal_code                    varchar2(30)   not null,   -- �ײ�CODE
   fmeal_name                    varchar2(40)   not null,   -- �ײ�����
   fquantity                     number(6,0)    not null,   -- ����
   --
   -- ���͵�
   --
   fdelive_note_id               varchar2(32),              -- ���͵�id   
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
   constraint pk_delive_detail primary key (fdetail_id),
   constraint uk_delive_detail unique (fdelive_note_id,fmeal_id)
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
