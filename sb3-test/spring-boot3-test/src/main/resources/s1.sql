CREATE TABLE public.user_account_pw_1(
                                     user_id BIGINT NULL,
                                     username VARCHAR (50) NULL,
                                     password_hash VARCHAR (255) NULL,
                                     full_name VARCHAR (100) NULL,
                                     email VARCHAR (100) NULL,
                                     phone VARCHAR (20) NULL,
                                     role VARCHAR (30) NULL,
                                     department VARCHAR (50) NULL,
                                     is_active BOOLEAN NULL,
                                     last_login TIMESTAMPTZ NULL,
                                     created_at TIMESTAMPTZ NULL,
                                     updated_at TIMESTAMPTZ NULL
);
COMMENT ON COLUMN public.user_account_pw_1.user_id IS '用户ID，自增主键';
COMMENT ON COLUMN public.user_account_pw_1.username IS '用户名，唯一标识';
COMMENT ON COLUMN public.user_account_pw_1.password_hash IS '加密后的密码';
COMMENT ON COLUMN public.user_account_pw_1.full_name IS '用户全名';
COMMENT ON COLUMN public.user_account_pw_1.email IS '电子邮箱，唯一';
COMMENT ON COLUMN public.user_account_pw_1.phone IS '联系电话';
COMMENT ON COLUMN public.user_account_pw_1.role IS '用户角色(admin, manager, staff等)';
COMMENT ON COLUMN public.user_account_pw_1.department IS '所属部门';
COMMENT ON COLUMN public.user_account_pw_1.is_active IS '账户是否激活';
COMMENT ON COLUMN public.user_account_pw_1.last_login IS '最后登录时间';
COMMENT ON COLUMN public.user_account_pw_1.created_at IS '创建时间';
COMMENT ON COLUMN public.user_account_pw_1.updated_at IS '更新时间';
COMMENT ON TABLE public.user_account_pw_1 IS '系统用户表';