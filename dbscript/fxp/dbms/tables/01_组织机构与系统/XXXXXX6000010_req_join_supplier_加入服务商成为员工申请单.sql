--
-- ɢ�ͼ�����������뵥
--
--
-- v1.0 2016.08.26
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.req_join_supplier;
Create Table  fxp.req_join_supplier (
-- +-----------------------------+--------------+-----------+
   freqnote_id                   varchar2(32)   not null,   -- ���뵥id
   --
   -- ���뵥��Ϣ
   --
   fsupplier_id                  varchar2(32)   not null,   -- ������id
   fuser_id                      varchar2(32)   not null,   -- �û�id
   fuser_name                    varchar2(30)   not null,   -- �û�name
   freq_desc                     varchar2(60),              -- ���뱸ע
   --
   -- ��������Ϣ
   --
   fcreate_time                  date           not null,   -- ����ʱ��
   fcreate_user_id               varchar2(32)   not null,   -- ��������id
   fcreate_nickname              varchar2(30)   not null,   -- ��������
   --
   -- ������Ϣ
   --
   --
   -- ���뵥״̬  1�� ���½�  2 �ѽ���  3�� �Ѿܾ�
   --
   --
   flast_state                   varchar2(30)   not null,   -- ���״̬�����ʱID
   flast_time                    date           not null,   -- �������ʱ��
   flast_user_id                 varchar2(32)   not null,   -- ������ɲ���Աid
   flast_nickname                varchar2(40)   not null,   -- ������ɲ���Աname
   flast_desc                    varchar2(256),             -- ���̱�ע
   --
   -- ��һ���ڵ���Ϣ�����ô�����Ϊ���
   --
   fnext_node_id                 varchar2(30),              -- ��һ���� �������ͻ���״̬����עͬʱ����
   fnext_node_content            varchar2(300),             -- ��һ���ڹ�������
   --
   -- �����Ϣ
   --
   fis_complete                   char(1)       not null,   -- ���뵥�Ƿ�����ɣ�  Y/N
   fcomplete_state                varchar2(30),             -- ���״̬  SUCCESS  �ɹ�  FAIL ʧ�ܣ�ȡ����
   fcomplete_time                 date,                     -- ���ʱ��
   fcomplete_user_id              varchar2(32),             -- ��ɹ���id
   fcomplete_nickname             varchar2(30),             -- �������
   fcomplete_desc                 varchar2(256),            -- ��ɱ�ע
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
   constraint pk_req_join_supplier primary key (freqnote_id)
);



--
-- ͬ���
--
--
-- ��Ȩ
--

--
--����
--
create index fxp.idx_req_join_supplier_complete on fxp.req_join_supplier(fis_complete);
create index fxp.idx_req_join_supplier_supplier on fxp.req_join_supplier(fsupplier_id);
create index fxp.idx_req_join_supplier_time     on fxp.req_join_supplier(flast_time);
--
-- �޸���䣺
--
--
