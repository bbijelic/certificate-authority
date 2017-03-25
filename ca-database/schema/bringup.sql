USE certauthority;

-- Roles
INSERT INTO Role (slug, name, description) VALUES ("ADMIN", "Administrator", "Certificate authority administrator");

-- Principals
-- email: user@ca, password: user
INSERT INTO Principal (email, password, salt) VALUES ("admin@ca", "a5b158291ac7d4fb754e120ddb027dbdcb219afdb1533d7e956f468a4bd938b2", "f69547f6632056e1e6df8d754b5dd90bf10894edbfdd2454dc368a5edde3d3ce");

-- Principal role mapping
-- admin@ca to ADMIN
INSERT INTO PrincipalRoleMap (principal_id, role_id) VALUES ((SELECT id FROM Principal WHERE email="admin@ca"), (SELECT id FROM Role WHERE slug="ADMIN"));