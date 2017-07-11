--
-- �û���Ϣ��
--
-- v1.0 2016.10.17
-- author��wing
--
-- ˵��
-- 1��
--
--
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_user_message;
Create Table  fxp.p_user_message (
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
   --
   -- 
   --
   fis_read                      char(1)        not null,   -- �Ƿ����Ķ���  Y/N   
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
   constraint pk_p_user_message primary key (fmessage_id),
   constraint uk_p_user_message unique (fnote_type_id,fnote_id)
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
create index fxp.idx_p_user_message_receive on fxp.p_user_message(freceive_user_id);
--
-- �޸���䣺
--

