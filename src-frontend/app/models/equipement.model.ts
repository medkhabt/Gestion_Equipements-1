export class Equipement {
    constructor(
        public id: number,
        public nom: string,
        public  idResponsable: number,
        public  adresse: string,
        public largeur: number,
        public longueur: number
        ) {}
}
