export class Gestionnaire {

        public id: number;
        public username: string;
        public password: string;
        public actived: true;
        public nom: string;
        public prenom: string;
        public email: string;
        public telephone: string;
        public roles: [];
        public reservations: [];
}
export class Demandeur {

        public id: number;
        public username: string;
        public password: string;
        public actived: boolean;
        public nom: string;
        public prenom: string;
        public email: string;
        public telephone: string;
        public adresse: string;
        public type: string;
        public roles: Role[];
        public demandes: [];
}
class Role {
        public role: string;
        public description: string;
}
