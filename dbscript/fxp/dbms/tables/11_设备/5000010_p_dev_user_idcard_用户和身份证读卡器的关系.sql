--
-- ���֤���������û��İ󶨹�ϵ
--
-- v1.0 2016.12.10
-- author��alex
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_dev_user_idcard;
create table  fxp.p_dev_user_idcard (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   fuser_name                    varchar2(50)   not null,   -- �û�����
   --
   -- �豸����
   --
   fdevice_sn                    varchar2(32)   not null,   -- �豸���к�
   --
   -- ������Ϣ
   --
   fbind_date                    date           not null,   -- ���һ�ΰ󶨵�ʱ��
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
   constraint pk_p_dev_user_idcard primary key (fuser_id)
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
-- �޸���ʷ��
--
