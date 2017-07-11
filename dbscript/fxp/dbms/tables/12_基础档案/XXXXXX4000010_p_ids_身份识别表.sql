--
-- ���ʶ���
--
-- v1.0 2016.10.08
-- author��wing
--
-- �޸���ʷ��
-- 
--
--   
-- drop table fxp.p_ids;
create table  fxp.p_ids (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�id
   --
   -- ���˻�����Ϣ
   -- 
   fidtype_id                    varchar2(32),              -- ֤�����id ->p_id_typ
   fidtype_name                  varchar2(30),              -- ֤���������     ΢��Ĭ�϶������֤
   fid_no                        varchar2(30),              -- ֤����ţ����֤��
   fbirth_date                   date,                      -- ��������, ����ͨ���������ڼ��������
   --
   -- ��ס���
   --
   fregion_id                    varchar2(32),              -- ��������ID�����а���ʡ���С������ֵ��������ĸ������룩����ֻ����ײ��ַ�ı��룬�����ϼ����룩
   fregion_name                  varchar2(80),              -- �����������ƣ����������������������ƣ��磺�㶫ʡ�����з�خ��)
   faddress                      varchar2(200),             -- ��ϸ��ַ���ֵ�֮�����ϸ��ַ��
   --
   -- ��ϵ�绰
   --
   fuser_mobile                  varchar2(30),              -- ע���ֻ�
   fuser_desc                    varchar2(256),             -- �ͻ���ע
   -- 
   -- ������
   --
   fagent_name                   varchar2(30),              -- ����������
   fagent_mobile                 varchar2(30),              -- �������ֻ�     
   --
   -- ����
   --
   fcreate_date                   date default sysdate not null, -- ע�����ڣ�¼��ʱ��������ڣ� 
   fcreate_user_id                varchar2(32),              -- ע�����Աid
   fcreate_user_name              varchar2(30),              -- ע�����Ա����
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date default sysdate not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date default sysdate not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date default sysdate not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_ids primary key (fuser_id),
   constraint uk_p_ids_idno unique (fid_no),
   constraint uk_p_ids_mobile unique (fuser_mobile)
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
create index idx_p_ids_agent_mobile on fxp.p_ids(fagent_mobile);
