--
-- ��ϵͳ�����ű�
--
-- ������ϵͳ��ʹ���ߣ����ţ���
--
-- v1.0 2015.11.08
-- author��wing
--
-- ˵����
--
--
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_subsys_dept;
create table fxp.p_subsys_dept (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- ����id
   fdept_id                      varchar2(32)   not null,   -- ����id
   fsubsys_id                    varchar2(32)   not null,   -- Ӧ����ϵͳid ����
   fordernum                     number(6,2)    not null,   -- �����
   fdesc                         varchar2(256),             -- ��ע
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,    -- ������
   flogcdate                     date           not null,    -- ����ʱ��
   flogluby                      varchar2(32)   not null,    -- ����޸���
   flogludate                    date           not null,    -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,    -- ��������
   flogladate                    date           not null,    -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_subsys_dept primary key (forg_id,fdept_id,fsubsys_id)
   --
   -- CheckԼ��
   --
);
