import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Vigilante } from '../../models/vigilante';

@Injectable({ providedIn: 'root' })
export class VigilantesService {

    constructor(private apiService: ApiBaseService) {

    }

    async getAll(): Promise<Vigilante[]> {
        return await this.apiService.get<Vigilante[]>("/vigilante");
    }

    async getPorNombre(nombre: string): Promise<Vigilante> {
        let vigilantes = await this.getAll();
        return vigilantes.find(x => nombre == x.nombre);
    }
    
    async create(vigilante: Vigilante) {
        return await this.apiService.post("/vigilante", vigilante);
    }

    async update(vigilante: Vigilante) {
        return await this.apiService.put("/vigilante/modificar", vigilante);
    }

    async delete(codigo: string) {
        return await this.apiService.delete(`/vigilante/${codigo}`);
    }


}