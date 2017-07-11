--
-- ��Ͷ�����
--
-- v1.0 2017.04.30
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table nxft.nxft_order;
create table  nxft.nxft_order (
-- +-----------------------------+--------------+-----------+
   forder_id                     varchar2(32)   not null,   -- ����ID
   --
   -- ������Ϣ
   -- 
   fsubject_id                   varchar2(32)   not null,   -- ����id   
   fsubject_name                 varchar2(80)   not null,   -- ����
   fsex_id                       varchar2(32)   not null,   -- �Ա�id
   fsex_name                     varchar2(30)   not null,   -- �Ա�name   
   fcontact_phone                varchar2(30)   not null,   -- ��ϵ�绰
   fregion_id                    varchar2(32)   not null,   -- ��������ID
   fregion_name                  varchar2(80)   not null,   -- ������������
   faddress                      varchar2(200),             -- ��ϸ��ַ
   fsubject_type_id              varchar2(32)   not null,   -- ��������id
   fsubject_type_name            varchar2(30)   not null,   -- ������������
   flunch_box_no                 varchar2(20),              -- ���б��
   fsubject_desc                 varchar2(256),             -- ����ע
   --
   -- �ͻ�����
   --
   fcircle_id                    varchar2(32)   not null,   -- �ͻ������Ĺ���Ȧid
   --
   -- �����Ϣ
   --
   fdelive_type                  varchar2(30)   not null,   -- ���ͷ�ʽ  ���͵� SITE  ����  HOME
   fdelive_site_id               varchar2(32)   not null,   -- ���͵ص�id
   fdelive_site_name             varchar2(40)   not null,   -- ���͵ص�����
   fdelive_addr                  varchar2(100)  not null,   -- ���͵�ַ  �� fdelive_type = HOME �� faddress  = SITE �� fdelive_site_name
   fdelive_fee                   number(4,2)    not null,   -- ���ͷ�   
   --
   -- ����
   --
   fkitchen_circle_id            varchar2(32)   not null,   -- ����Ȧid
   fkitchen_team_id              varchar2(32)   not null,   -- ����teamid
   --
   -- �Ű�
   --
   fmeal_date                    date           not null,   -- �Ͳ�����
   fweek                         number(1)      not null,   -- �ܼ�
   fmeal_type_id                 varchar2(32)   not null,   -- �ͱ�ID
   fmeal_type_name               varchar2(40)   not null,   -- �ͱ�����
   fmeal_id                      varchar2(32)   not null,   -- �ײ�id
   fmeal_code                    varchar2(30)   not null,   -- �ײ�CODE
   fmeal_name                    varchar2(40)   not null,   -- �ײ�����
   fmeal_content                 varchar2(60)   not null,   -- �ײ�����
   fmeal_price                   number(4,2)    not null,   -- ����
   fschedule_desc                varchar2(256),             -- ��ע
   --
   -- ���
   --
   fquantity                     number(6,0)    not null,   -- ����
   fsum_total                    number(10,2)   not null,   -- ���
   fsum_payment                  number(10,2)   not null,   -- �����Ը����
   fsum_receivable               number(10,2)   not null,   -- Ӧ�ս��
   --
   -- ���͵�
   --
   fdelive_note_id               varchar2(32),              -- ���͵�id   
   --
   --  �½���Ϣ
   --
-- +-----------------------------+--------------+-----------+   
   fcreate_time                  date           not null,   -- ����ʱ��
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_user_name             varchar2(50)   not null,   -- ��������Ա����
   fcreate_way                   varchar2(20)   not null,   -- ���ͷ�ʽ  ��ϯ  ���͵�
   --
   -- ������Ϣ
   --
   --
   -- ����״̬  1�� ���ɵ�  2�� �ѽӵ�   4��������  5���ѷ���   6����ȡ��   
   --
   --
   flast_state                   varchar2(30)   not null,   -- ���״̬�����ʱID
   flast_time                    date           not null,   -- �������ʱ��
   flast_user_id                 varchar2(32)   not null,   -- ������ɲ���Աid
   flast_nickname                varchar2(40)   not null,   -- ������ɲ���Աname
   flast_desc                    varchar2(256),             -- ���̱�ע����Ϊ�˵������˵�ԭ��
   --
   -- ��һ���ڵ���Ϣ�����ô�����Ϊ���  ACCEPT  �ӵ�  DELIVE  ����  GIVE ����
   --
   fnext_node_id                 varchar2(30),              -- ��һ���� �������ͻ���״̬����עͬʱ����
   fnext_node_content            varchar2(300),             -- ��һ���ڹ�������
   --
   -- ���������Ϣ
   --
   fis_complete                  char(1)        not null,   -- �Ƿ�����ɣ�  Y/N
   fcomplete_state               varchar2(30),              -- ���״̬  SUCCESS  �ɹ�  FAIL ʧ�ܣ�ȡ����
   ffail_reason_name             varchar2(50),              -- ʧ��ԭ������  ����  �ͻ�ȡ��
   fcomplete_time                date,                      -- ���ʱ��
   fcomplete_user_id             varchar2(32),              -- ��ɲ���Ա����id
   fcomplete_nickname            varchar2(30),              -- ��ɲ���Ա����
   fcomplete_desc                varchar2(256),             -- ��ɱ�ע   
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
   constraint pk_nxft_order primary key (forder_id)
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
