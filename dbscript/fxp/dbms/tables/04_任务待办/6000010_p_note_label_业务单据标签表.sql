--
-- ҵ�񵥾ݱ�ǩ��
--
-- v1.0 2017.03.16
-- author��wing
--
-- ˵��
--
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_note_label;
create table  fxp.p_note_label (
-- +-----------------------------+--------------+-----------+
   flabel_id                     varchar2(32)   not null,   -- ��ǩID
   flabel_name                   varchar2(80)   not null,   -- ��ǩ����
   --
   -- ���񵥾�����
   --
   fnote_type_id                 varchar2(30)   not null,   -- ��������ID    ��ͷ������
   fnote_id                      varchar2(150)  not null,   -- ҵ��Ҫ����ĵ�������,���������ö��ŷָ�   
   fcreate_time                  date           not null,   -- ����ʱ��
   fcreate_user_id               varchar2(32)   not null,   -- ��������id
   fcreate_nickname              varchar2(30)   not null,   -- ��������
   flabel_desc                   varchar2(256),             -- ��ע
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
   constraint pk_p_note_label primary key (flabel_id),
   constraint uk_p_note_label unique (fnote_type_id,fnote_id,flabel_name)
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
