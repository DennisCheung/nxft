--
-- �Զ�ִ�еĴ����������
--
-- v1.0 2016.06.12
-- author��wing
--
-- һ��˵����
-- 1�������Զ�ִ���������
-- 2���˱��¼��������ɾ����
--
-- ���ʣ�
--
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_todo_auto;
Create Table  fxp.p_todo_auto (
-- +-----------------------------+--------------+-----------+
   ftodo_id                      varchar2(32)   not null,   -- ����id
   --
   -- ���񵥾�����
   --
   fnote_type_id                 varchar2(30)   not null,   -- ��������ID    ��ͷ������
   fnote_id                      varchar2(150)  not null,   -- ����Ҫ����ĵ�������,���������ö��ŷָ�
   --
   -- ����˵��
   --
   ftodo_content                 varchar2(300)  not null,   -- ��������     ��Ҫ���������ڹ�������   ��ʽ���
   ftodo_remark                  varchar2(300),             -- ����ע
   fcreate_time                  date           not null,   -- ����ʱ��
   fnode_id                      varchar2(30)   not null,   -- ����ID
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
   constraint pk_p_todo_auto primary key (ftodo_id),
   constraint uk_p_todo_auto unique (fnote_type_id,fnote_id)
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

--
-- �޸���䣺
--

