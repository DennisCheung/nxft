--
-- ����豸���ű�
--
-- v1.0 2017.01.19
-- author��alex
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_dev_issue_hmo;
create table  fxp.p_dev_issue_hmo (
-- +-----------------------------+--------------+-----------+
   fissue_id                     varchar2(32)   not null,   -- ����ID
   --
   -- �û�
   --
   fperson_id                    varchar2(32)   not null,   -- �ͻ�ID
   fperson_name                  varchar2(50)   not null,   -- �ͻ�����
   --
   -- �豸����
   --
   fdevice_id                    varchar2(32)   not null,   -- �豸id
   fcompany_id                   varchar2(32)   not null,   -- �豸����_id
   fcompany_name                 varchar2(30)   not null,   -- �豸����_name
   fdevice_model_id              varchar2(32)   not null,   -- �豸�ͺ�ID
   fdevice_model_name            varchar2(50)   not null,   -- �豸�ͺ�����
   fmax_user                     number(3,0)    not null,   -- �豸����û�����Ĭ��Ϊ1
   fdevice_sn                    varchar2(32)   not null,   -- �豸���к�
   fdevice_uuid                  varchar2(32),              -- �豸�ڲ�ID
   fproduction_date              date,                      -- ��������
   fpurchase_date                date,                      -- ��������
   fuser_no                      number(3,0)    not null,   -- �û����
   fdevice_Desc                  varchar2(256),             -- ��ע
   --
   -- APP�û���������
   --
   fapp_username                 varchar2(50),              -- APP�ĵ�¼�û���
   fapp_password                 varchar2(50),              -- APP�ĵ�¼�û�����
   --
   -- ��������Ȧ
   --
   fcircle_id                   varchar2(32),              -- ����Ȧid      
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
   constraint pk_p_dev_issue_hmo primary key (fissue_id),
   constraint uk_p_dev_issue_hmo_device unique (fdevice_id,fuser_no),
   constraint uk_p_dev_issue_hmo_sn unique (fdevice_sn,fcompany_id,fdevice_model_id,fuser_no)
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
-- �޸���ʷ��
--
