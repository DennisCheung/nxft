--
-- �����������
--
-- v1.0 2015.11.03
-- author��wing
--
-- һ��˵����
-- 1��������������ҵ���������ν��ã�Ϊһ��ҵ����������֮�乵ͨ��������
-- 2������������֪ͨ��һ�����ڣ�����Ϊ��һ�����ڿ�ʼ��������ڡ�
-- 3�������͡��������һ���ڵ�����
-- 4���˱��¼��������ɾ����
--
-- ���ʣ�
-- 1��fnote_type �������� �Ƿ�������Ϊҵ�����͡�
-- 2��fnode_id   �����ж�����ڵ�ҵ��������Ϊ���ڣ�����ֻ��һ�����ڵ�ҵ���Ƿ�������Ϊ ҵ�������ͣ���������� �� �طò��֡�
-- 3���ط��Ƿ�ֻ��һ�����ڣ�
--
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_todo;
Create Table  fxp.p_todo (
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
   fnote_tag                     varchar2(128)  not null,   -- ����tag ��������ʱ�� 'DEFAULT'
   ficon_file                    varchar2(30)   not null,   -- ͼ���ļ������� abc.jpg  ����ͼ��·����ͬ���ɳ���ͳһ����
   fblock_no                     varchar2(10)   not null,   -- ����
   fordernum                     number(6,2)    not null,   -- �����
   --
   -- ����
   --
   fis_grabbed                   char(1)        not null,   -- �Ƿ�������  Y/N
   fgrab_time                    date,                      -- ����ʱ��
   fgrab_circle_id               varchar2(32),              -- ��������Ȧid
   fgrab_team_id                 varchar2(32),              -- ����������id
   fgrab_user_id                 varchar2(32),              -- ��������Աid
   fgrab_user_name               varchar2(40),              -- ��������Ա����
   --
   -- �ͻ���Ϣ
   --
   fperson_id                    varchar2(32),              -- ����ID
   fperson_name                  varchar2(50),              -- ��������
   ffamily_id                    varchar2(32),              -- ��ͥid
   fcircle_id                    varchar2(32),              -- ����Ȧid 
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
   constraint pk_p_todo primary key (ftodo_id),
   constraint uk_p_todo unique (fnote_type_id,fnote_id)
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

