--
-- ��ͥ�豸���ձ�
--
-- v1.0 2017.06.10
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_dev_recycle_family;
create table  fxp.p_dev_recycle_family (
-- +-----------------------------+--------------+-----------+
   frecycle_id                   varchar2(32)   not null,   -- ����ID
   --
   -- �û�
   --
   ffamily_id                    varchar2(32)   not null,   -- ��ͥID
   --
   -- �豸����
   --
   fdevice_id                    varchar2(32)   not null,   -- �豸id
   fdevice_type_id               varchar2(32)   not null,   -- �豸����ID
   fdevice_type_name             varchar2(50)   not null,   -- �豸��������
   fcompany_id                   varchar2(32)   not null,   -- �豸����_id
   fcompany_name                 varchar2(30)   not null,   -- �豸����_name
   fdevice_model_id              varchar2(32)   not null,   -- �豸�ͺ�ID
   fdevice_model_name            varchar2(50)   not null,   -- �豸�ͺ�����
   fdevice_sn                    varchar2(32)   not null,   -- �豸���к�
   fdevice_uuid                  varchar2(32),              -- �豸�ڲ�ID
   fproduction_date              date,                      -- ��������
   fpurchase_date                date,                      -- ��������
   fdevice_Desc                  varchar2(256),             -- ��ע
   --
   -- ��������Ȧ
   --
   fcircle_id                    varchar2(32),              -- ����Ȧid      
   --
   -- ����
   --
   fissue_date                   date           not null,   -- ����ʱ��
   fissue_circle_id              varchar2(32)   not null,   -- ���Ź���Ȧid
   fissue_team_id                varchar2(32)   not null,   -- ���Ź�����id
   fissue_team_name              varchar2(100)  not null,   -- ���Ź���������     
   fissue_user_id                varchar2(32)   not null,   -- ���Ų���Աid
   fissue_nickname               varchar2(40)   not null,   -- ���Ų���Ա����
   fissue_desc                   varchar2(256),             -- ���ű�ע
   --
   -- ����
   --
   frecycle_date                 date           not null,   -- ����ʱ��
   frecycle_circle_id            varchar2(32)   not null,   -- ���չ���Ȧid
   frecycle_team_id              varchar2(32)   not null,   -- ���չ�����id
   frecycle_user_id              varchar2(32)   not null,   -- ���ղ���Աid
   frecycle_nickname             varchar2(40)   not null,   -- ���ղ���Ա����
   frecycle_desc                 varchar2(256),             -- ���ձ�ע    
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
   constraint pk_p_dev_recycle_family primary key (frecycle_id)
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
create index fxp.idx_p_dev_recycle_family_sn on fxp.p_dev_recycle_family (fdevice_sn);
create index fxp.idx_p_dev_recycle_family_fam on fxp.p_dev_recycle_family (ffamily_id);

--
-- �޸���ʷ��
--
