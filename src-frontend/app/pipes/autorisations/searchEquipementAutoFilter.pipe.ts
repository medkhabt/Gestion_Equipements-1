import { PipeTransform, Pipe } from '@angular/core';

@Pipe({
    name: 'SearchEquipemenAutorisationtFilter',
    pure: false
})
export class SearchEquipementAutoFilter implements PipeTransform {
    transform(autorisations: any, searchSubject: string): any {
        if (!autorisations || !searchSubject) {
            console.log('viiiiide!!!');
            return autorisations;
        }
        console.log('probleeeme!!!');
        console.log(autorisations.filter(autorisation =>
            autorisation.reservation.etat.indexOf(searchSubject)
        ));
        return autorisations.filter(autorisation =>
            autorisation.reservation.equipement.nom.indexOf(searchSubject) !== -1
        );
    }
}
