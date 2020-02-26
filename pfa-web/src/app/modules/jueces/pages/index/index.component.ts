import { Component, OnInit } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { BandasService } from 'src/app/core/services/api/bandas.service';
import { JuecesEditComponent } from '../edit/edit.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Juez } from 'src/app/core/models/juez';
import { JuecesService } from 'src/app/core/services/api/jueces.service';
import { AuthService } from 'src/app/core/services/api/auth.service';

@Component({
    selector: 'bandas-index',
    templateUrl: 'index.component.html'
})

export class JuecesIndexComponent implements OnInit {
    jueces: Juez[];

    constructor(private juecesService: JuecesService,
        private modalService: NgbModal,public authService: AuthService) {
    }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        this.jueces = await this.juecesService.getAll();
    }

    async edit(juez: Juez = null) {
        const modalRef = this.modalService.open(JuecesEditComponent);

        if (juez) {
            modalRef.componentInstance.codigo = juez.codigo;
        }

        var result = await modalRef.result;
        debugger;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete($event, juez: Juez) {
        debugger;
        await this.juecesService.delete(juez.codigo);
        this.getAll();
        $event.stopPropagation();
    }
}