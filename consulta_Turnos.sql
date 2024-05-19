select fechora_tunos, b.apellido_Paciente, b.nombre_Paciente, b.email_Paciente, b.cel_wsp_Paciente, c.nombre_Prestador, c.plan_Prestador
from turnos as a, pacientes as b, prestadores as c
where a.Pacientes_id_Pacientes=b.id_Pacientes and a.Prestadores_id_Prestador=C.id_Prestador
