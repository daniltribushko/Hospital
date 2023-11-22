create table wards(
	id SERIAL PRIMARY KEY NOT NULL,
	countHospitalBed INTEGER NOT NULL,
	isFull boolean
);