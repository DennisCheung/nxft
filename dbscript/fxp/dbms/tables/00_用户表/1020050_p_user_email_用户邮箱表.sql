--
-- �û������
--
-- v1.0 2015.11.09
-- author��wing
--
-- ˵��
-- 1���˱�Ϊ��¼�û���ע�����䣬���ע���������ʹ�����¹���
--   �� �������룬ͨ���������ӣ��ҵ����롣
--   �� ��������ŵ�¼
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_user_email;
create table  fxp.p_user_email (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   femail_no                     varchar2(30)   not null,   -- �����
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
   constraint pk_p_user_email primary key (fuser_id),
   constraint uk_p_user_email unique (femail_no)
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
