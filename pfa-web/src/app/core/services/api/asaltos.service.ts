import { Injectable } from '@angular/core';
import { ApiBaseService } from './api-base.service';
import { Asalto } from '../../models/asalto';

@Injectable({
    providedIn: 'root'
})
export class AsaltosService {

    constructor(private apiService: ApiBaseService) { }

    getAll() {
        return this.apiService.get<Asalto[]>(`asalto/obtenerTodos`);
    }

    getById(id: number) {
        return this.apiService.get<Asalto>(`asalto/ObtenerPorId/${id}`);
    }

    create(asalto: Asalto) {
        this.apiService.post("asalto/crear", asalto);
    }

    update(asalto: Asalto) {
        this.apiService.put("asalto/guardar", asalto);
    }

    delete(id: number) {
        this.apiService.delete(`asalto/eliminar/${id}`);
    }
}