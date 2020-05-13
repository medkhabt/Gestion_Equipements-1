import { Equipement } from 'src/app/models/equipement.model';

export class Demande {
    constructor(
        public typeEvent: string, 
        public dateReservation: string, 
        public objet: string, 
        public equipement: Equipement, 
        public nombrePresent: number, 
        public dateDemande: string, 
        public description: string
    ){}
}