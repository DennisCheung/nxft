--
-- �û��ֻ��ű�
--
-- v1.0 2015.07.29
-- author��wing
--
-- ˵��
-- 1���˱�Ϊ��¼�û����ֻ��ţ�����Ǽ��ֻ��������ʹ�����¹���
--   �� ͨ���ֻ����룬�ҵ����롣
--   �� �����ֻ��ŵ�¼
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_user_mobile;
create table  fxp.p_user_mobile (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   fmobile_no                    varchar2(30)   not null,   -- �ֻ���
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
   constraint pk_p_user_mobile primary key (fuser_id),
   constraint uk_p_user_mobile unique (fmobile_no)
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
