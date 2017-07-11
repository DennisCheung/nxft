--
-- �ͻ�����Ա��
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_person_helper;
create table  fxp.p_person_helper (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- ����id
   fhelper_id                    varchar2(32)   not null,   -- ����Աid
   fhelper_name                  varchar2(40)   not null,   -- ����Ա����
    --
   fperson_id                    varchar2(32)   not null,   -- �ͻ�ID�� 
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fhelper_desc                  varchar2(256),             -- ��ע
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
   constraint pk_p_person_helper primary key (fpk_id),
   constraint uk_p_person_helper unique (fperson_id,fhelper_id)
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
