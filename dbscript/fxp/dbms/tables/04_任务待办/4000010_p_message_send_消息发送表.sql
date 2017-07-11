--
-- ��Ϣ���ͱ�
--
-- v1.0 2016.09.07
-- author��wing
--
-- ˵��
-- 1����̨��ҵ��ʱ��ѯ��Ϣ���ͱ�������΢����ҵ�ŷ�����Ϣ�ӿ�
-- 2����Ϣ������Ϻ󣬽���ϢǨ�Ƶ�p_message_history
-- 3���Ķ���Ϣ�����Ӳ�ѯ p_message_history
--
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_message_send;
Create Table  fxp.p_message_send (
-- +-----------------------------+--------------+-----------+
   fmessage_id                   varchar2(32)   not null,   -- ��Ϣid
   --
   -- ��Ϣ��������
   --
   fnote_type_id                 varchar2(30)   not null,   -- ��������ID    ��ͷ������
   fnote_id                      varchar2(150)  not null,   -- ����Ҫ����ĵ�������,���������ö��ŷָ�
   --
   -- ��Ϣ˵��
   --
   fmessage_title                varchar2(300)  not null,   -- ��Ϣ����
   fmessage_content              varchar2(300)  not null,   -- ��Ϣ����     ��Ҫ���������ڹ�������
   fnode_id                      varchar2(30)   not null,   -- ����ID
   --
   -- ����
   --
   fsend_time                    date           not null,   -- ����ʱ��
   fsend_circle_id               varchar2(32),              -- ���͹���Ȧid
   fsend_team_id                 varchar2(32),              -- ���͹�����id
   fsend_user_id                 varchar2(32)   not null,   -- ���Ͳ���Աid
   --
   -- ����
   --
   freceive_circle_id            varchar2(32),              -- ���չ���Ȧid
   freceive_team_id              varchar2(32),              -- ���չ�����id
   freceive_user_id              varchar2(32)   not null,   -- ���ղ���Աid
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
   constraint pk_p_message_send primary key (fmessage_id),
   constraint uk_p_message_send unique (fnote_type_id,fnote_id)
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

