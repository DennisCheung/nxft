--
-- �������ͱ�
--
-- ˵����
--
--
-- v1.0 2015.11.04
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_note_type;
create Table  fxp.p_note_type (
-- +-----------------------------+--------------+-----------+
   fnote_type_id                 varchar2(32)   not null,   -- ��������ID
   fnote_type_name               varchar2(40)   not null,   -- ��������NAME
   fordernum                     number(6,2)    not null,   -- �����
   fnote_type_desc               varchar2(256),             -- ��ע
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
   constraint pk_p_note_type primary key (fnote_type_id)
);

