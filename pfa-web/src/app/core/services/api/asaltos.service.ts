import { Injectable } from '@angular/core';
import { ApiBaseService } from './api-base.service';
import { Asalto } from '../../models/asalto';

@Injectable({
    providedIn: 'root'
})
export class AsaltosService {

    constructor(private apiService: ApiBaseService) { }

    async getAll() {
        return await this.apiService.get<Asalto[]>(`asalto/obtenerTodos`);
    }

    async getById(id: number) {
        return await this.apiService.get<Asalto>(`asalto/ObtenerPorId/${id}`);
    }

    async create(asalto: Asalto) {
        debugger;
        await this.apiService.post("asalto/crear", asalto);
    }

    async update(asalto: Asalto) {
        await this.apiService.put("asalto/guardar", asalto);
    }

    async delete(id: number) {
        await this.apiService.delete(`asalto/eliminar/${id}`);
    }
}