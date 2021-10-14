import { TestBed } from '@angular/core/testing';

import { EmployeeService } from './employee.service';

describe('EmployeeService', () => {
  let service: EmployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmployeeService] //Added this
    });
    service = TestBed.inject(EmployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});


import { of } from 'rxjs'; // Add import

describe('UsersService', () => {
  ...

  it('should be created', () => {
    expect(usersService).toBeTruthy();
  });

  // Add tests for all() method
  describe('all', () => {
    it('should return a collection of employees', () => {
      const userResponse = [
        {
          id: '1',
          firstName: 'Jane',
          lastName: 'Dani',
          emailId: 'janed@gmail.com'
        },
        {
          id: '2',
          firstName: 'Bob',
          lastName: 'Dev',
          emailId: 'bobd@gmail.com'
        }
      ];
      let response;
      spyOn(service, 'all').and.returnValue(of(userResponse));

      service.all().subscribe(res => {
        response = res;
      });

      expect(response).toEqual(userResponse);
    });
  });
});