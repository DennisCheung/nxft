--
-- ���ݻ��ڱ�
--
--
-- ˵����
-- 1��ÿ���������;�Ϊ��������Ӧ��Ӧ�ı���
--
--
-- v1.0 2015.11.04
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_note_node;
create Table  fxp.p_note_node (
-- +-----------------------------+--------------+-----------+
   fnote_type_id                 varchar2(30)   not null,   -- ��������ID
   fnode_id                      varchar2(30)   not null,   -- ����ID
   fnode_name                    varchar2(50)   not null,   -- ����˵��
   fordernum                     number(6,2)    not null,   -- �����
   fnode_desc                    varchar2(256),             -- ��ע
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
   constraint pk_p_note_node primary key (fnote_type_id,fnode_id)
);

--
-- ͬ���
--

commit;
