--
-- ְ����
--
-- v1.0 2015.06.01
-- author��wing
--
-- ˵����
-- 1. �ֻ������䡢΢�ź� ��������һ����Ϊ��
-- 2. ����ְ������ͬʱ��ְ����p_user ��������һ����¼��
-- 3. ��΢����ҵ��ְ��������ͬ����ʽ
--    1��ÿ������ȫ����¡�
--    2��PC��ά��ÿ��������ְ������ͬ����ť��ͬ��������ְ����
-- 4. PC��ͨ������ϵͳ�û��� �� P_USER ��¼ϵͳ��
-- 5. ΢����ҵ���˺� = ְ������
-- 6. ΢����ҵ�� femp_code -> fuser_id  -> p_user ��ȡ fuser_id��fuser_name = femp_name
--    ΢����ҵ���ò��� �û�΢�Ű󶨱�  p_user_wechat
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_employee;
create table  fxp.p_employee (
-- +-----------------------------+--------------+-----------+
   femp_id                       varchar2(32)   not null,   -- ְ��id
   femp_code                     varchar2(20)   not null,   -- ְ������(ְ���˺ţ���Ψһ
   femp_name                     varchar2(30)   not null,   -- ְ������
   fsex_id                       varchar2(32),     			    -- �Ա�id
   fsex_name                     varchar2(10),     			    -- �Ա�����
   fbirth_date                   date,                      -- ��������
   --
   -- ��������
   --
   forg_id                       varchar2(32)   not null,   -- ��������id
   fdept_id                      varchar2(32)   not null,   -- V1.1 ����id
   --
   -- ͨѶ¼
   --
   fposition                     varchar2(100),             -- ְλ������Ϣ
   fmobile                       varchar2(30),              -- �ֻ�
   femail                        varchar2(30),              -- ����
   fwechat                       varchar2(30),              -- ΢�ź�
   fqq                           varchar2(30),              -- qq��
   --
   fuser_id                      varchar2(32),              -- �û�id��p_user.fuser_id��
   femp_desc                     varchar2(256),             -- ����
-- +-----------------------------+--------------+-----------+
   fisavailable                  char(1)        not null,   -- �Ƿ���Ч��
  --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
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
   constraint pk_p_employee primary key (femp_id),
   constraint uk_p_employee_code unique (femp_code),
   constraint uk_p_employee_mobile unique (fmobile),
   constraint uk_p_employee_email unique (femail),
   constraint uk_p_employee_wechat unique (fwechat),
   constraint uk_p_employee_user unique (fuser_id)
   --
   -- Լ��
   --
);

--
-- ��Ȩ
--

--
-- ����
--
create index fxp.idx_p_employee2 on fxp.p_employee (forg_id);

--
-- �޸����
--
