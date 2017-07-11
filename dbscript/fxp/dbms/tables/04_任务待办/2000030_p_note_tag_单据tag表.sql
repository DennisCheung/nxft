--
-- ����tag��
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
-- Drop Table fxp.p_note_tag;
create Table  fxp.p_note_tag (
-- +-----------------------------+--------------+-----------+
   fnote_type_id                 varchar2(30)   not null,   -- ��������ID
   fnode_id                      varchar2(30)   not null,   -- ����ID
   fnode_tag                     varchar2(128)  not null,   -- ����tag
   ficon_file                    varchar2(30)   not null,   -- ͼ���ļ������� abc.jpg  ����ͼ��·����ͬ���ɳ���ͳһ����
   fblock_no                     varchar2(10)   not null,   -- ����
   fordernum                     number(6,2)    not null,   -- �����
   ftag_desc                     varchar2(256),             -- ��ע
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
   constraint pk_p_note_tag primary key (fnote_type_id,fnode_id,fnode_tag),
   constraint ck_p_note_tag_block   check (fblock_no in ('1','2'))
   );

--
-- ͬ���
--

