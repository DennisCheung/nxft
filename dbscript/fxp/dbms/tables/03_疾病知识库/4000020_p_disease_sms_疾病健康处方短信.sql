--
-- ���������������ű�
--
-- v1.0 2015.11.11
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_disease_sms;
create table  fxp.p_disease_sms (
-- +-----------------------------+--------------+-----------+
   fdisease_id                   varchar2(32)   not null,   -- ����ID
   --
   -- ָ������
   --
   fguide_sms                    varchar2(2000) not null,   -- ����ָ������
   fdesc                         varchar2(256),             -- ��ע
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
   constraint pk_p_disease_sms primary key (fdisease_id)
);

--
-- ͬ���
--
