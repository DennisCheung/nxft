--
-- ���͵���
--
-- v1.0 2017.03.04
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table nxft.delive_note;
create table  nxft.delive_note (
-- +-----------------------------+--------------+-----------+
   fdelive_note_id               varchar2(32)   not null,   -- ���͵�ID
   --
   -- �ͻ�����
   --
   fcircle_id                    varchar2(32)   not null,   -- �ͻ������Ĺ���Ȧid
   --
   -- �����Ϣ
   --
   fdelive_type                  varchar2(30)   not null,   -- ���ͷ�ʽ  ���͵� SITE  ��������  HOME
   fdelive_site_id               varchar2(32)   not null,   -- ���͵ص�id
   fdelive_site_name             varchar2(40)   not null,   -- ���͵ص�����
   fdelive_addr                  varchar2(100)  not null,   -- ���͵�ַ  = fxp.p_team.faddress  
   fcontact_person               varchar2(30),              -- ��ϵ��
   fcontact_mobile               varchar2(30),              -- ��ϵ�ֻ�   
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
   --
   -- ����
   --
   fquantity                     number(6,0)    not null,   -- ����
   fquantity_desc               varchar2(300)   not null,   -- ��������
   --
   --  �½���Ϣ
   --
-- +-----------------------------+--------------+-----------+   
   fcreate_time                  date           not null,   -- ����ʱ��
   fcreate_user_id               varchar2(32)   not null,   -- ��������Աid
   fcreate_user_name             varchar2(50)   not null,   -- ��������Ա����
   --
   -- ������Ϣ
   --
   --
   -- ����״̬  1�� �ѽӵ�     2��������   3�����ʹ�
   --
   --
   flast_state                   varchar2(30)   not null,   -- ���״̬�����ʱID
   flast_time                    date           not null,   -- �������ʱ��
   flast_user_id                 varchar2(32)   not null,   -- ������ɲ���Աid
   flast_nickname                varchar2(40)   not null,   -- ������ɲ���Աname
   flast_desc                    varchar2(256),             -- ���̱�ע����Ϊ�˵������˵�ԭ��
   --
   -- ��һ���ڵ���Ϣ�����ô�����Ϊ���  DELIVE  ����  ARRIVE  �ʹ�
   --
   fnext_node_id                 varchar2(30),              -- ��һ���� �������ͻ���״̬����עͬʱ����
   fnext_node_content            varchar2(300),             -- ��һ���ڹ�������
   --
   -- ���������Ϣ
   --
   fis_complete                  char(1)        not null,   -- �Ƿ�����ɣ�  Y/N
   fcomplete_state               varchar2(30),              -- ���״̬  SUCCESS  �ɹ�  FAIL ʧ�ܣ�ȡ����
   ffail_reason_name             varchar2(50),              -- ʧ��ԭ������  ����  �ͻ�ȡ��������
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
   constraint pk_delive_note primary key (fdelive_note_id)
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
