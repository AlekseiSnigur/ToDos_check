| N | Case name                                            | Expected result                   | Passed Y/N |
|---|------------------------------------------------------|-----------------------------------|------------|
| 1 | Create task                                          | Task created                      | Y          |
| 2 | Delete incomplete task with "X" icon                 | Task deleted                      | Y          |
| 3 | Change task status                                   | Status changed                    | Y          |
| 4 | Delete completed task with "X" icon                  | Task deleted                      | Y          |
| 5 | Delete completed task with "Clear completed" button  | Task deleted                      | Y          |
| 6 | Delete incomplete task with "Clear completed" button | Task remains on page              | Y          |
| 7 | Create empty task                                    | Task will not create              | Y          |