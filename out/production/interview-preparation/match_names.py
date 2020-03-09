def match_names(names):
    start = dict()
    end = dict()
    result = []
    first = 0

    for i in range(len(names)):
        name = names[i]
        start_letter = name[0].lower()
        end_letter = name[-1].lower()
        start[start_letter] = i
        end[end_letter] = i
        
        if start_letter not in end:
            first = i
    
    result.append(names[first])
    
    j = 1
    while j < len(start.keys()) - 1:
        last_letter = start[result[-1][-1]]
        result.append(names[last_letter])
        j += 1
    print(result)

match_names(["Raymond", "Louie", "Peter", "Esteban", "Nora", "Daniel"])